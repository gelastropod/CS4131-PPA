package com.example.cs4131_ppa.pages

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalMapOf
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.cs4131_ppa.R
import com.example.cs4131_ppa.pages.components.TitleBarClass
import com.example.cs4131_ppa.ui.theme.Typography

class CompanyDetailsPageClass {
    companion object {
        @Composable
        fun CompanyDetailsPage(navController: NavController) {
            TitleBarClass.TitleBar (navController) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            ElevatedCard(
                                elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
                                colors = CardDefaults.cardColors(MaterialTheme.colorScheme.background)
                            ) {
                                Image(
                                    painter = painterResource(id = R.drawable.ppg_logo_icon_foreground),
                                    contentDescription = "Peak Performance Gear Logo"
                                )
                            }

                            Box(
                                modifier = Modifier.height(30.dp)
                            )

                            Text(
                                text = stringResource(id = R.string.tagline),
                                style = MaterialTheme.typography.titleLarge,
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold

                            )
                            Box(
                                modifier = Modifier.height(30.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.company_desc),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                    Box(
                        modifier = Modifier.height(10.dp)
                    )
                    ElevatedCard(
                        elevation = CardDefaults.cardElevation(defaultElevation = 6.dp)
                    ) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(10.dp)
                        ) {
                            Text(
                                text = stringResource(id = R.string.contact_title),
                                style = MaterialTheme.typography.titleLarge,
                                fontWeight = FontWeight.Bold

                            )
                            Box(
                                modifier = Modifier.height(30.dp)
                            )
                            Text(
                                text = stringResource(id = R.string.contact_info),
                                textAlign = TextAlign.Justify,
                                modifier = Modifier.fillMaxWidth()
                            )
                        }
                    }
                }
            }
        }
    }
}