package com.coding.practice.string;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author : Velmurugan Moorthy
 * @date : 15/09/2021
 * Problem name : Simplify Directory Path
 *
 * Given a string A representing an absolute path for a file (Unix-style).
 *
 * Return the string A after simplifying the absolute path.
 *
 * Note:
 *
 *     Absolute path always begin with '/' ( root directory ).
 *
 *     Path will not have whitespace characters.
 *
 *
 * Input Format
 *
 * The only argument given is string A.
 *
 * Output Format
 *
 * Return a string denoting the simplified absolue path for a file (Unix-style).
 *
 * For Example
 *
 * Input 1:
 *     A = "/home/"
 * Output 1:
 *     "/home"
 *
 * Input 2:
 *     A = "/a/./b/../../c/"
 * Output 2:
 *     "/c"
 */
public class DirectoryPathSimplifyingDriver {
    public static void main(String[] args) {

//        String absolutePath = "/directory1/directory2/directory3/";//Test case #1 - Happy flow - PASS
//        String absolutePath = "/directory1/directory2/./directory3/";//Test case #2 with single dot - PASS
//        String absolutePath = "/directory1/directory2/../directory3/../../../../";//Test case #3 double dots - PASS
//        String absolutePath = "/dir1/";//Test case #4 single directory - PASS
//        String absolutePath = "/dir1/       /dir3/";//Test case #5 blank spaces as directory name - PASS
        String absolutePath =  "/a/./b/../../c/";//Test case #6 failing test case
        //String absolutePath = "";//Test case #

        DirectoryPathSimplifyTools directoryPathSimplifyTools = new DirectoryPathSimplifyTools();
        String simplePath = directoryPathSimplifyTools.simplifyFilePath(absolutePath);
        System.out.println("simplePath is : " + simplePath);
    }
}

/**
 * Algorithm :
 *
 * 1. Tokenize the absolute path
 * 2. Push each tokens into the stack
 * 3. Pop one element if the token is (.)
 * 4. Pop two elements if the token is (..)
 */
class DirectoryPathSimplifyTools{
    public String simplifyFilePath(String absolutePath){

        List<String> directoryNames = fetchDirectoryNames(absolutePath);
        directoryNames.forEach(directoryName -> System.out.println(directoryName));
        Stack<String> directoryPathStack = new Stack<String>();

        populateDirectoryNameStack(directoryNames, directoryPathStack);

        StringBuilder simplePathBuilder = new StringBuilder("/");
        prepareSimplifiedPath(directoryPathStack, simplePathBuilder);

        return simplePathBuilder.toString();
    }

    private void prepareSimplifiedPath(Stack<String> directoryPathStack, StringBuilder simplePathBuilder) {
        for(int loopIndex = 0; loopIndex < directoryPathStack.size() - 1; loopIndex++){
           if(directoryPathStack.get(loopIndex).trim().isEmpty()){
                return;
            }
            else {
                simplePathBuilder.append(directoryPathStack.get(loopIndex)).append("/");
            }
        }
        if(!directoryPathStack.isEmpty() &&
                !"..".equals(directoryPathStack.get(directoryPathStack.size()-1)) &&
                !".".equals(directoryPathStack.get(directoryPathStack.size()-1))
        ){
            simplePathBuilder.append(directoryPathStack.get(directoryPathStack.size()-1));
        }
    }

    private void populateDirectoryNameStack(List<String> directoryNames, Stack<String> directoryPathStack) {
        for(int loopIndex = 0; loopIndex < directoryNames.size(); loopIndex++){
            if(!directoryPathStack.isEmpty() && directoryNames.get(loopIndex).equals(".")){
                //directoryPathStack.pop();
            }
            else if(!directoryPathStack.isEmpty() && directoryNames.get(loopIndex).equals("..")){
                directoryPathStack.pop();
            }
            else {
             directoryPathStack.push(directoryNames.get(loopIndex));
            }
        }
    }

    //Use 2 pointers
    private List<String> fetchDirectoryNames(String absolutePath) {

        List<String> directoryNames = new ArrayList<>();

        int absolutePathLength = absolutePath.length();
        int start = 0;
        int end = 0;
        StringBuilder directoryNameBuilder = new StringBuilder();

        while(start < absolutePathLength && end < absolutePathLength){
         //if(start == 0 && end == 0 || absolutePath.charAt(end) == ' '){
            if(start == 0 && end == 0){
             //directoryNameBuilder.append(absolutePath.charAt(start));
             end++;
             continue;
         }
          if(absolutePath.charAt(end) != '/'){
              directoryNameBuilder.append(absolutePath.charAt(end));
              end++;
          }
          else if(absolutePath.charAt(end) == '/' && end < absolutePathLength - 1){
              if(!directoryNameBuilder.toString().isEmpty()){
                  directoryNames.add(directoryNameBuilder.toString());
              }
              start = (end + 1 < absolutePathLength) ? end + 1 : absolutePathLength - 1;
              end = start;
              directoryNameBuilder = new StringBuilder();
              continue;
          }

          else if(end == absolutePathLength - 1){
              break;
          }
        }

        //Handling file names ending without /

        if(!directoryNameBuilder.toString().isEmpty()){
            directoryNames.add(directoryNameBuilder.toString());
        }

        return directoryNames;
    }
}