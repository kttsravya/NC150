package SystemDesign;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

public class TokenBucketRateLimiter {

    private final ConcurrentHashMap<String, TokenBucket> buckets = new ConcurrentHashMap<>();

    public boolean allowRequest(String clientId) {
        TokenBucket bucket = buckets.computeIfAbsent(clientId, id -> new TokenBucket(10, 1)); // Initialize bucket with max 10 tokens and refill 1 token/sec
        return bucket.tryConsume();
    }

    class TokenBucket {
        private final int maxTokens;
        private final int refillRate;
        private long lastRefillTimestamp;
        private int currentTokens;

        public TokenBucket(int maxTokens, int refillRate) {
            this.maxTokens = maxTokens;
            this.refillRate = refillRate;
            this.currentTokens = maxTokens;
            this.lastRefillTimestamp = System.nanoTime();
        }

        public synchronized boolean tryConsume() {
            refill();

            if (currentTokens > 0) {
                currentTokens--;
                return true;
            }
            return false;
        }

        private void refill() {
            long now = System.nanoTime();
            long timeElapsed = now - lastRefillTimestamp;

            // Refill tokens based on the elapsed time
            int tokensToAdd = (int) (timeElapsed / TimeUnit.SECONDS.toNanos(1)) * refillRate;
            if (tokensToAdd > 0) {
                currentTokens = Math.min(maxTokens, currentTokens + tokensToAdd);
                lastRefillTimestamp = now;
            }
        }
    }

    public static void main(String[] args) {
        TokenBucketRateLimiter rateLimiter = new TokenBucketRateLimiter();

        // Simulate requests for a client
        for (int i = 0; i < 15; i++) {
            boolean allowed = rateLimiter.allowRequest("client1");
            System.out.println("Request " + (i + 1) + " allowed: " + allowed);
        }
    }
}

