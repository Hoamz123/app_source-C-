package com.example.project_mini.Data;

import com.example.project_mini.R;

import java.util.List;

public class Agrt {

   public static List<String> name_Ag = List.of(
         "Bubble Sort - Sắp xếp nổi bọt",
         "Selection Sort - Sắp xếp chọn",
         "Insertion Sort - Sắp xếp chèn",
         "Quick Sort - Sắp xếp nhanh",
         "Merge Sort - Sắp xếp trộn",
         "Heap Sort - Sắp xếp vun đống",
         "Counting Sort - Sắp xếp đếm");

   public static List<String> complexity = List.of(
           "Average Case : O(n²)",
           "Average Case : O(n²)",
           "Average Case : O(n²)",
           "Average Case : O(nlog(n))",
           "Average Case : O(nlog(n))",
           "Average Case : O(nlog(n))",
           "Average Case : O(n + k)"
           );

    public static List<Integer>  code_detail = List.of(
         R.drawable.bs,R.drawable.selection,R.drawable.insert,R.drawable.qs,R.drawable.merger,R.drawable.logo,R.drawable.logo
    );

}
