package com.withjetpack.profile_screen_jetpack_jetpack_compose.viewmodel

import androidx.lifecycle.ViewModel
import com.withjetpack.profile_screen_jetpack_jetpack_compose.R
import com.withjetpack.profile_screen_jetpack_jetpack_compose.model.UserProfile
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class UserProfileViewModel @Inject constructor() : ViewModel() {
    private val _userProfile = MutableStateFlow<UserProfile?>(null)
    val userProfile: StateFlow<UserProfile?> = _userProfile

    suspend fun loadData() {

        _userProfile.value = UserProfile(
            username = "Chayan chowdhury",
            email = "chayanchowdhury@gmail.com",
            profileImage = R.drawable.ic_launcher_foreground,
            bluetoothDeviceName = "One Plus Device",
            bluetoothDeviceAddress = "00:11:22:33:44:55"
        )
    }}
