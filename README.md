# Lab 6 - Sorting

## Using the n data, use a spreadsheet program to use regression to figure out the complexity. When you use a regression line, save the chart with the R2 R2 values included (do not show the equations). Explain what the R2 R2 values imply.

The R^2 values are a statistical measure of how close the data is to the fitted regression line

## Given the plots from (1), what can you say about the algorithms worst-case vs. average case? Are they equivalent? Use qualitative analysis, quantitative is not required.
  
For Selection Sort and MergeSort the worst and average case times will be the same, however for the other two sorting algorithims that will not be true. Which is why Merge Sort can be faster than quicksort while on average they have the same time complexity, quicksort can have a worse case.

## For the two major trade-offs between operation time and comparison time, which algorithm should be used in the case of large latency in each? Explain why.
  
Looking at comparisons per sort Merge sort preformed best with the least comparisons usually, and also had great operation time for larger data, however the R^2 value was a lot higher then quick sort which had basically the same efficiency, so I would still pick Quick Sort.

## Overall, what is the worst sorting algorithm we have? Justify your answer.
  
overall selection sort does the most comparator comparison Ops, while insertion sort does the most list comparisons. Meaning the 2 algorithms are not as efficient as Quick and Merge.On average Selection Sort toom longer and is therefore the worst algorithim.

## Calculate the ratios of the average comparison of complexity of the algorithms against the "best" algorithm. This is the ratio of average time for an algorithm divided by the best algorithm. Create a table showing the comparisons.

![alt tag](https://raw.githubusercontent.com/uwoece-se2205b-2017/lab-6-sorting-JedraPeake/master/Capture.PNG?token=AXFuEVPMG4VLtT7knHnvo6GfA4knCZcgks5Y3abxwA%3D%3D)
