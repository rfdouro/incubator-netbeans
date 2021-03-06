/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package org.netbeans.modules.maven.j2ee.ui.wizard;

import java.awt.Component;
import javax.swing.event.ChangeListener;
import org.netbeans.modules.j2ee.deployment.devmodules.api.J2eeModule;
import org.openide.WizardDescriptor;
import org.openide.util.HelpCtx;

class EELevelPanel implements WizardDescriptor.FinishablePanel<WizardDescriptor> {

    private final J2eeModule.Type projectType;
    private EELevelPanelVisual panel;

    public EELevelPanel(J2eeModule.Type projectType) {
        this.projectType = projectType;
    }

    @Override
    public Component getComponent() {
        return panel();
    }

    private EELevelPanelVisual panel() {
        if (panel == null) {
            panel = new EELevelPanelVisual(projectType);
        }
        return panel;
    }

    @Override public void readSettings(WizardDescriptor wiz) {
        panel().readSettings(wiz);
    }

    @Override public void storeSettings(WizardDescriptor wiz) {
        panel.storeSettings(wiz);
    }

    @Override public boolean isFinishPanel() {
        return true;
    }

    @Override public boolean isValid() {
        return true;
    }

    @Override
    public void addChangeListener(ChangeListener l) {
    }

    @Override
    public void removeChangeListener(ChangeListener l) {
    }

    @Override public HelpCtx getHelp() {
        return null;
    }

}
