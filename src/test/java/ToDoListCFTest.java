import com.sda.kth.ToDoListCF;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.*;
/**
 *  The purpose of this Test class is to test methods of the class ToDoListCF.
 */
public class ToDoListCFTest {

    private ByteArrayInputStream testIn;
    private ByteArrayOutputStream testOut;

    private String provideInput(String data) {
        testIn = new ByteArrayInputStream(data.getBytes());
        System.setIn(testIn);
        return "";
    }

    /**
     * This test Method is used to validate whether nth occurring index of a particular character is correctly retrieved.
     * To confirm the tests substring operation is used on the String.
     */
    @Test
    void CheckOrdinalIndexOfAString() {
        ToDoListCF ComFunc = new ToDoListCF();
        String input = "001;BluePrint;RPA1;25/03/2021;Pending ";
        String expected_output = "RPA1";

      int startIndex =   ComFunc.ordinalIndexOf(input, ";", 1);
      int endIndex =  ComFunc.ordinalIndexOf(input, ";", 2);
      String output = input.substring(startIndex+1,endIndex);
        assertEquals(expected_output,output);
    }

    /**
     * This test Method is used to validate whether nth occurring index of a particular character is correctly retrieved.
     * To confirm the tests substring operation is used on the String and the desired result is compared with inCorrect value.
     */
    @Test
    void CheckOrdinalIndexOfAStringAndCompareForIncorrectValue() {
        ToDoListCF ComFunc = new ToDoListCF();
        String input = "001;BluePrint;RPA1;25/03/2021;Pending ";
        String expected_output = "BluePrint";

        int startIndex =   ComFunc.ordinalIndexOf(input, ";", 1);
        int endIndex =  ComFunc.ordinalIndexOf(input, ";", 2);
        String output = input.substring(startIndex+1,endIndex);
        assertNotEquals(expected_output,output);
    }

    /**
     * This test Method helps to validate padding(suffix) of a particular character,
     * in front of the input string .
     */
    @Test
    void CheckRightPaddingForAgivenString() {
        String input = "BluePrint";
        String expected_output = "BluePrint######";
        ToDoListCF ComFunc = new ToDoListCF();

        assertEquals(ComFunc.rightPadding(input,'#',15),expected_output);
    }

    /**
     * This test Method helps to validate padding(suffix) of a particular character,
     * in front of the input string. Desired output is compared with incorrectly padded string.
     */
    @Test
    void CheckRightPaddingForAGivenStringAndCompareWithIncorrectOutput() {
        String input = "BluePrint";
        String expected_output = "BluePrint##############";
        ToDoListCF ComFunc = new ToDoListCF();

        assertNotEquals(ComFunc.rightPadding(input,'#',15),expected_output);
    }


    /**
     * This test Method helps to take the input from the user for the project field ,and  return the same .
     *  It also tests whether it replaces all semicolons entered by user with a comma .And also tests whether
     *  it restricts/truncates the length of the project to 15 characters.
     */
 @Test
    void ReadProjectNameAsUserInputFromConsole()
    {
        String Input_Project = "AXA-CORPORATION-Private-LIMITED";
        String expected_Project = "AXA-CORPORATIO";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Project);

        String Output_Project = ComFunc.userInputProject(provideInput(Input_Project));
        assertEquals(Output_Project, expected_Project);

    }

    /**
     * This test Method helps to checks whether it restricts/truncates the length of the project to 15 characters.
     * when the expected length is more than 15 characters ,the method should fail(assert nor equals).
     */
    @Test
    void checkToReadProjectNameAsUserInputFromConsoleInCorrectLength()
    {
        String Input_Project = "AXA-CORPORATION-Private-LIMITED";
        String expected_Project = "AXA-CORPORATION-Private-";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Project);

        String Output_Project = ComFunc.userInputProject(provideInput(Input_Project));
        assertNotEquals(Output_Project, expected_Project);

    }

    /**
     * This test Method helps to take the input from the user for the DueDate field ,and return the same .
     */
    @Test
    void checkToReadDateAsUserInputFromConsole()
    {
        String Input_Date = "22/05/2021";
        String expected_Date = "22/05/2021";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Date);

        String Output_Date = ComFunc.userInputProject(provideInput(Input_Date));
        assertEquals(Output_Date, expected_Date);

    }
    /**
     * This test Method helps to checks whether the entered date by user has valid format 'dd/MM/yyyy
     */

    @Test
    void checkToReadDateInWrongFormatAsUserInputFromConsole() {
        String Input_Date = "22-03-2007";
        String expected_Date = "22/03/2007";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Date);

        String Output_Date = ComFunc.userInputProject(provideInput(Input_Date));
        assertNotEquals(Output_Date, expected_Date);
    }

    /**
     * This test Method helps to take the input from the user for the status of the task.
     * If the status entered by user does not match Pending or Done ,then the default status of the
     * task would be Pending
     */
    @Test
    void checkToReadStatusAsUserInputFromConsole() {
        String Input_Status = "Done";
        String expected_status = "Done";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Status);

        String Output_Status = ComFunc.userInputStatus(provideInput(Input_Status));
        assertEquals(Output_Status, expected_status);
    }

    /**
     * This test Method helps to check if the status entered by user is other than Pending or Done  ,then the default status of the
     *  task would be Pending.
     */
    @Test
    void ReadStatusAsUserInputFromConsoleAndValidateDefaultStatus() {
        String Input_Status = "inComplete";
        String expected_DefaultStatus = "Pending";
        ToDoListCF ComFunc = new ToDoListCF();
        provideInput(Input_Status);

        String Output_Status = ComFunc.userInputStatus(provideInput(Input_Status));
        assertEquals(Output_Status, expected_DefaultStatus);
    }
    }
