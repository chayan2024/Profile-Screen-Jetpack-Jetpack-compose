package com.withjetpack.profile_screen_jetpack_jetpack_compose.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.withjetpack.profile_screen_jetpack_jetpack_compose.common.ToolBar
import com.withjetpack.profile_screen_jetpack_jetpack_compose.viewmodel.UserProfileViewModel

@Composable
fun ProfileScreen(viewModel: UserProfileViewModel = hiltViewModel()) {

    LaunchedEffect(key1 = viewModel) {
        viewModel.loadData()
    }

    val userProfile by viewModel.userProfile.collectAsState()

    ToolBar()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp,70.dp)
    ) {

            userProfile?.profileImage.let { imageResource ->
                imageResource?.let { painterResource(id = it) }?.let {
                    Image(
                        painter = it,
                        contentDescription = null,
                        modifier = Modifier
                            .size(120.dp)
                            .clip(CircleShape)
                            .background(MaterialTheme.colors.primary).align(Alignment.CenterHorizontally)
                    )
                }
        }
        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "User name:",
                style = MaterialTheme.typography.h5.copy(
                    fontSize = 20.sp
                ),
                fontWeight = FontWeight.Light,
            )
            userProfile?.username?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h5.copy(
                        fontSize = 18.sp
                    ),                    fontWeight = FontWeight.Light,
                    modifier = Modifier
                )
            }
        }


        Spacer(modifier = Modifier.height(5.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Email Id:",
                style = MaterialTheme.typography.h5.copy(
                    fontSize = 20.sp
                ),
                fontWeight = FontWeight.Light,
            )
            userProfile?.email?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h5.copy(
                        fontSize = 16.sp
                    ),
                    fontWeight = FontWeight.Light,
                )
            }        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Bluetooth Information : ",
                style = MaterialTheme.typography.h5.copy(
                    fontSize = 20.sp
                ),
                fontWeight = FontWeight.Light,
            )

            userProfile?.bluetoothDeviceName?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h5.copy(
                        fontSize = 16.sp
                    ),
                    fontWeight = FontWeight.Light,
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = "Bluetooth Address : ",
                style = MaterialTheme.typography.h5.copy(
                    fontSize = 20.sp
                ),
                fontWeight = FontWeight.Light,
            )

            userProfile?.bluetoothDeviceAddress?.let {
                Text(
                    text = it,
                    style = MaterialTheme.typography.h5.copy(
                        fontSize = 16.sp
                    ),
                    fontWeight = FontWeight.Light,
                )
            }
        }
    }
}

