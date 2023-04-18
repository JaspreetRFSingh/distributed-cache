package com.cache.consistency;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.*;
@Component
@Slf4j
public class QuorumReader {
    public boolean hasQuorum(int responses, int totalNodes) {
        return responses > totalNodes / 2;
    }
}
