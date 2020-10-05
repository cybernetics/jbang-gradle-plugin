/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Copyright 2020 Andres Almiray.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kordamp.gradle.plugin.jbang

import groovy.transform.CompileStatic
import org.gradle.api.Action
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin
import org.kordamp.gradle.plugin.jbang.tasks.JBangTask

/**
 * @author Andres Almiray
 */
@CompileStatic
class JBangPlugin implements Plugin<Project> {
    void apply(Project project) {
        Banner.display(project)

        project.plugins.apply(BasePlugin)

        project.tasks.register('jbang', JBangTask,
            new Action<JBangTask>() {
                @Override
                void execute(JBangTask t) {
                    t.group = 'Other'
                    t.description = 'Executes JBang'
                }
            })
    }
}
