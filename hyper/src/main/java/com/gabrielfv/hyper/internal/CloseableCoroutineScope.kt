package com.gabrielfv.hyper.internal

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.cancel
import java.io.Closeable
import kotlin.coroutines.CoroutineContext

internal class CloseableCoroutineScope(
    override val coroutineContext: CoroutineContext
) : Closeable, CoroutineScope {

    override fun close() {
        coroutineContext.cancel()
    }
}