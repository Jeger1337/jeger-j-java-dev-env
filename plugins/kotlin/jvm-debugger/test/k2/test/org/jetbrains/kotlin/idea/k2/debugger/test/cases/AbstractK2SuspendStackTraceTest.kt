// Copyright 2000-2022 JetBrains s.r.o. and contributors. Use of this source code is governed by the Apache 2.0 license.

package org.jetbrains.kotlin.idea.k2.debugger.test.cases

import org.jetbrains.kotlin.config.JvmClosureGenerationScheme
import org.jetbrains.kotlin.config.JvmTarget
import org.jetbrains.kotlin.idea.debugger.test.AbstractSuspendStackTraceTest
import org.jetbrains.kotlin.idea.debugger.test.DebuggerTestCompilerFacility
import org.jetbrains.kotlin.idea.debugger.test.TestCompileConfiguration
import org.jetbrains.kotlin.idea.debugger.test.TestFiles
import org.jetbrains.kotlin.idea.k2.debugger.test.K2DebuggerTestCompilerFacility

abstract class AbstractK2IdeK1CodeSuspendStackTraceTest : AbstractSuspendStackTraceTest() {

    override fun createDebuggerTestCompilerFacility(
        testFiles: TestFiles,
        jvmTarget: JvmTarget,
        compileConfig: TestCompileConfiguration,
    ): DebuggerTestCompilerFacility {
        return K2DebuggerTestCompilerFacility(project, testFiles, jvmTarget, compileConfig)
    }
}

abstract class AbstractK2IdeK2CodeSuspendStackTraceTest : AbstractK2IdeK1CodeSuspendStackTraceTest() {
    override val compileWithK2 = true

    override fun lambdasGenerationScheme() = JvmClosureGenerationScheme.INDY
}