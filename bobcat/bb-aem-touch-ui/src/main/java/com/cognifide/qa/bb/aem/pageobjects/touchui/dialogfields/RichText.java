/*-
 * #%L
 * Bobcat Parent
 * %%
 * Copyright (C) 2016 Cognifide Ltd.
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package com.cognifide.qa.bb.aem.pageobjects.touchui.dialogfields;

import static org.openqa.selenium.Keys.BACK_SPACE;
import static org.openqa.selenium.Keys.CONTROL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import com.cognifide.qa.bb.qualifier.PageObject;
import com.cognifide.qa.bb.aem.data.componentconfigs.FieldType;
import com.google.inject.Inject;

@PageObject
public class RichText implements DialogField {

  @FindBy(css = ".coral-RichText")
  private WebElement input;

  @Inject
  private Actions actions;

  @Override
  public void setValue(Object value) {
    actions.keyDown(input, CONTROL) //
        .sendKeys("a") //
        .keyUp(CONTROL) //
        .sendKeys(BACK_SPACE) //
        .sendKeys(String.valueOf(value)) //
        .perform();
  }

  @Override
  public String getType() {
    return FieldType.RICHTEXT.name();
  }
}