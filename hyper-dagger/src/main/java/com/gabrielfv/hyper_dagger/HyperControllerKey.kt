package com.gabrielfv.hyper_dagger

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

/**
 * It would be preferable if we could reduce the scope of the key
 * to support only classes that are covariant on HyperController<*, *>,
 * but dagger apparently isn't very fond of the idea. There's an issue
 * open in dagger repository about this behavior (https://github.com/google/dagger/issues/2000)
 */
@MapKey
@Retention(AnnotationRetention.BINARY)
@Target(AnnotationTarget.FUNCTION)
annotation class HyperControllerKey(val value: KClass<out Fragment>)