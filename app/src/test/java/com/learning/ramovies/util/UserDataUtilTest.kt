package com.learning.ramovies.util

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class UserDataUtilTest {
    var testObject: UserDataUtil? = null

    @Before
    fun setup() {
        testObject = UserDataUtil()
    }

    @Test
    fun getDisplayNameShouldReturnNullWhenUsernameIsNull() {
        val actualDisplayName = testObject?.getDisplayName(null)
        assertNull(actualDisplayName)
    }

    @Test
    fun getDisplayNameShouldReturnUnmodifiedNameWhenUsernameIsEqualToOrLessThan9Chars() {
        val expectedDisplayName = "Jellybean"
        val actualDisplayName = testObject?.getDisplayName(expectedDisplayName)
        assertEquals(expectedDisplayName, actualDisplayName)
    }

    @Test
    fun getDisplayNameShouldReturnModifiedNameWhenUsernameIsMoreThan9Chars() {
        val testName = "Jellybeans"
        val expectedDisplayName = "Jellybean..."
        val actualDisplayName = testObject?.getDisplayName(testName)
        assertEquals(expectedDisplayName, actualDisplayName)
    }
}