package com.example.worklazy.ui.components




import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.worklazy.ui.theme.Primary
import com.example.worklazy.ui.theme.Primary2
import com.example.worklazy.ui.theme.WorkLazyTheme


@Composable

fun BaseButton(
    onClick: () -> Unit = {},
    enabled: Boolean,
    modifier: Modifier,
    color: Color = MaterialTheme.colorScheme.primary,
    content: @Composable RowScope.() -> Unit
) {

    Surface(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .clickable { onClick() }, color = if (enabled) color else Primary2,contentColor= Color.White
    ) {
        Row (horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){

            content()
        }

    }


}

@Composable
fun PrimaryButton(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {

    BaseButton(
        modifier = modifier,
        onClick = onClick,
        enabled = enabled,

        ) {
        Text(text = text, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))
    }
}
@Composable
fun CircleButton(
    text: String,
    onClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true
) {

    BaseButton(
        modifier = modifier
            .clip(CircleShape)
            .height(200.dp)
            .width(200.dp),
        onClick = onClick,
        enabled = enabled,

        ) {
        Text(text = text, textAlign = TextAlign.Center, modifier = Modifier.padding(10.dp))
    }
}

@Preview
@Composable
fun CusttomButtonPreview() {
    WorkLazyTheme {
        CircleButton("Trabalhe")

    }
}

