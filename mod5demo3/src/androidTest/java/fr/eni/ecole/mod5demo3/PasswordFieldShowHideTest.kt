package fr.eni.ecole.mod5demo3

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assert
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.performClick
import androidx.compose.ui.test.performTextInput
import androidx.compose.ui.unit.dp
import org.junit.Rule
import org.junit.Test

class PasswordFieldShowHideTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun show(){
        composeTestRule.setContent {
            Surface(modifier = Modifier.fillMaxSize()) {
                Password(modifier = Modifier.padding(10.dp))
            }
        }
        composeTestRule.onNodeWithTag(TEST_TAG_FIELD_PWD).performTextInput("CeciEstUnMotDePasse")
        composeTestRule.onNodeWithContentDescription("Show password").performClick()
        composeTestRule.onNodeWithTag(TEST_TAG_FIELD_PWD).assert(hasText("CeciEstUnMotDePasse"))
        composeTestRule.onNodeWithContentDescription(("Hide password")).assertIsDisplayed()
    }
}