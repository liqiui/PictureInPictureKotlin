package com.example.android.pictureinpicture

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        viewModel = MainViewModel()
    }

    @Test
    fun testStartOrPause() {
        // Start the stopwatch
        viewModel.startOrPause()
        assertEquals(true, viewModel.started.value)

        // Pause the stopwatch
        viewModel.startOrPause()
        assertEquals(false, viewModel.started.value)
    }

    @Test
    fun testClear() {
        val viewModel = MainViewModel()
        viewModel.startOrPause()
        viewModel.clear()

        val observer = Observer<String?> { value ->
            assertEquals("00:00:00", value)
        }
        viewModel.time.observeForever(observer)
    }
}
