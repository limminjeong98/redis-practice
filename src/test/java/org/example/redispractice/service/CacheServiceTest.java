package org.example.redispractice.service;

import org.example.redispractice.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class CacheServiceTest {

    @Autowired
    private CacheService sut;

    @Test
    void cacheDataTest() {
        // Given
        User user = new User(1L, "testUser", "test@example.com", LocalDateTime.now());

        // When
        sut.cacheData("user:1", user, 60);
        Optional<User> cachedUser = sut.getCachedData("user:1", User.class);

        // Then
        assertTrue(cachedUser.isPresent());
        assertEquals(user.getUsername(), cachedUser.get().getUsername());
    }

    @Test
    void test() {

    }
}