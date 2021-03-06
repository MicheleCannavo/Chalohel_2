/*------------------------------------------------------------------------------
 - Copyright (c) 2021 Cannavo' Michele. All right reserved.
 -
 -  This file is part of UtilConsole
 -
 -     UtilConsole is free software: you can redistribute it and/or modify
 -     it under the terms of the Lesser GNU General Public License as published by
 -     the Free Software Foundation, either version 3 of the License, or
 -     (at your option) any later version.
 -
 -     UtilConsole is distributed in the hope that it will be useful,
 -     but WITHOUT ANY WARRANTY; without even the implied warranty of
 -     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 -     Lesser GNU General Public License for more details.
 -
 -     You should have received a copy of the Lesser GNU General Public License
 -     along with UtilConsole.  If not, see <http://www.gnu.org/licenses/>.
 -----------------------------------------------------------------------------*/

package chalohel.utility.validator;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.emptyStandardInputStream;

/**
 * The type Test validate generic.
 */
public class TestValidateGeneric {

  /**
   * The Vg.
   */
  AbstractValidator vg;

  /**
   * Pre condition.
   */
  @Before
  public void preCondition(){
    vg = new ValidateGeneric("generic","^[0-6]{1,}$");
  }

  /**
   * Gets descriptor rules validation.
   */
  @Test
  public void getDescriptorRulesValidation() {
    assertEquals("",
      vg.getRulesOfValidation());
  }

  /**
   * Gets pattern.
   */
  @Test
  public void getPattern() {
    assertEquals("^[0-6]{1,}$",
      vg.getPattern());
  }

  /**
   * Gets validator name.
   */
  @Test
  public void getValidatorName() {
    assertEquals("generic",
      vg.getValidatorName());
  }

  /**
   * Gets validator name.
   */
  @Test
  public void getValidatorNameIfNull() {
    var vg= new ValidateGeneric(null,"");
    assertEquals("anonymous", vg.getValidatorName());
  }

  /**
   * The type Testis valid.
   */
  @RunWith(Parameterized.class)
  public static class TestisValid {

    /**
     * The System in mock.
     */
    @Rule
    public final TextFromStandardInputStream systemInMock = emptyStandardInputStream();
    /**
     * The Str.
     */
    private final String str;
    /**
     * The Bool.
     */
    private final boolean bool;
    /**
     * The Vg.
     */
    private ValidateGeneric vg;

    /**
     * Instantiates a new Testis valid.
     *
     * @param str  the str
     * @param bool the bool
     */
    public TestisValid(String str, Boolean bool) {
      this.str = str;
      this.bool = bool;
      this.vg = new ValidateGeneric("generic","^[0-6]{1,}$");
    }

    /**
     * Gets param.
     *
     * @return the param
     */
    @Parameterized.Parameters
    public static Collection<Object[]> getParam() {

      return Arrays.asList(
        new Object[] {"GFHGl.it", false},
        new Object[] {"ass@rtit", false},
        new Object[] {"sdfs@live.it", false},
        new Object[] {"\0", false},
        new Object[] {"y", false},
        new Object[] {"...@..", false},
        new Object[] {"asds3@4...23", false},
        new Object[] {"@SdfsdSDFS.D", false},
        new Object[] {"00", true},
        new Object[] {"313@5465456", false},
        new Object[] {"49", false},
        new Object[] {"qw ds", false},
        new Object[] {"10632232032023032032000", true},
        new Object[] {null, false});

    }


    /**
     * Test is valid.
     */
    @Test
    public void testIsValid() {
      assertEquals(vg.isValid(str), bool);
    }

    /**
     * Test set validation rules.
     */
    @Test
    public void testSetValidationRules(){
      vg.setValidationRules(str);
      assertEquals(vg.getRulesOfValidation(), str);
    }
  }

  /**
   * Test validation rules is null.
   */
  @Test
  public void testValidationRulesIsNull(){
    vg.setValidationRules(null);
    assertEquals("", vg.getRulesOfValidation());
  }

  /**
   * Test validation rules is an string.
   */
  @Test
  public void testValidationRulesIsAnString(){
    vg.setValidationRules("string");
    assertEquals("string", vg.getRulesOfValidation());
  }

}