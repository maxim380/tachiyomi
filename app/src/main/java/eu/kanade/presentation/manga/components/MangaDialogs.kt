package eu.kanade.presentation.manga.components

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import eu.kanade.tachiyomi.R
import eu.kanade.domain.chapter.model.Chapter as DomainChapter

@Composable
fun DeleteChaptersDialog(
    onDismissRequest: () -> Unit,
    onConfirm: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDismissRequest,
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(R.string.action_cancel))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                    onConfirm()
                },
            ) {
                Text(text = stringResource(android.R.string.ok))
            }
        },
        title = {
            Text(text = stringResource(R.string.are_you_sure))
        },
        text = {
            Text(text = stringResource(R.string.confirm_delete_chapters))
        },
    )
}

@Composable
fun MissingChaptersDialog(
    onDismissRequest: () -> Unit,
    onConfirm: (DomainChapter) -> Unit,
    chapter: DomainChapter,
) {
    AlertDialog(
        onDismissRequest,
        dismissButton = {
            TextButton(onClick = onDismissRequest) {
                Text(text = stringResource(R.string.action_cancel))
            }
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                    onConfirm(chapter)
                },
            ) {
                Text(text = stringResource(android.R.string.ok))
            }
        },
        title = {
            Text(text = stringResource(R.string.missing_chapter))
        },
        text = {
            Text(text = stringResource(R.string.missing_chapters_message))
        },
    )
}
