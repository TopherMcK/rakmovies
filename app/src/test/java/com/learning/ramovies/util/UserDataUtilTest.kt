package com.learning.ramovies.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserDataUtilTest {

    @Test
    fun getDisplayNameShouldReturnNullWhenUsernameIsNull() {
        val actualDisplayName = UserDataUtil.getDisplayName(null)
        assertNull(actualDisplayName)
    }

    @Test
    fun getDisplayNameShouldReturnUnmodifiedNameWhenUsernameIsEqualToOrLessThan9Chars() {
        val expectedDisplayName = "Jellybean"
        val actualDisplayName = UserDataUtil.getDisplayName(expectedDisplayName)
        assertEquals(expectedDisplayName, actualDisplayName)
    }

    @Test
    fun getDisplayNameShouldReturnModifiedNameWhenUsernameIsMoreThan9Chars() {
        val testName = "Jellybeans"
        val expectedDisplayName = "Jellybean..."
        val actualDisplayName = UserDataUtil.getDisplayName(testName)
        assertEquals(expectedDisplayName, actualDisplayName)
    }
}