/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 * <p/>
 * http://www.apache.org/licenses/LICENSE-2.0
 * <p/>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.eagle.app;

import org.apache.eagle.app.environment.Environment;
import org.apache.eagle.app.environment.ExecutionRuntimeManager;
import com.typesafe.config.Config;

public abstract class ExecutableApplication<E extends Environment, P> implements Application<E, P>, ApplicationTool {
    @Override
    public void run(Config config) {
        ExecutionRuntimeManager.getInstance().getRuntime(getEnvironmentType(), config).start(this, config);
    }

    @Override
    public boolean isExecutable() {
        return true;
    }
}