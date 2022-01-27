import static org.junit.Assert.*; // import junit's assert

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

import org.junit.*; // import junit library

public class MarkdownParseTest { // file's class

    String file1;

    @Test // specifies that the following method is a test to JUnit
    public void addition() { // creates method header according to JUnit syntax
        assertEquals(2, 1 + 1); // asserts that 2 = 1+1
    }

    public void setup(String fileName) throws Exception {
            Path file = Path.of(fileName);
            file1 = Files.readString(file);
    }

    @Test
    public void customTest1() throws Exception {
        // public static ArrayList<String> getLinks(String markdown) {
        setup("test-file.md");
        ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
        assertEquals(fileContent.toString(), "[https://something.com, some-page.html]");
    }

    @Test
    public void customTest2() throws Exception {
        // public static ArrayList<String> getLinks(String markdown) {
        setup("new-file.md");
        ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
        assertEquals(fileContent.toString(), "[https://something.com, some-page.html]");
    }

    @Test
    public void customTest3() throws Exception {
        // public static ArrayList<String> getLinks(String markdown) {
        setup("new-file2.md");
        ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
        assertEquals(fileContent.toString(), "[google.com]");
    }

    @Test
    public void customTest4() throws Exception {
        // public static ArrayList<String> getLinks(String markdown) {
        setup("new-file3.md");
        ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
        assertEquals(fileContent.toString(), "[# title\n\n[]link goes here]");
    }

    // @Test
    // public void customTest5() throws Exception {
    //     // public static ArrayList<String> getLinks(String markdown) {
    //     setup("test-file2.md");
    //     ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
    //     assertEquals(fileContent.toString(), "[https://something.com, some-page.html]");
    // }

    @Test
    public void customTest6() throws Exception {
        // public static ArrayList<String> getLinks(String markdown) {
        setup("test-file3.md");
        ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
        assertEquals(fileContent.toString(), "[]");
    }

    @Test
    public void customTest7() throws Exception {
        // public static ArrayList<String> getLinks(String markdown) {
        setup("test-file4.md");
        ArrayList<String> fileContent = MarkdownParse.getLinks(file1);
        assertEquals(fileContent.toString(), "");
    }
}
