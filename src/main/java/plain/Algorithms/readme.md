
1、动态规划：
    如果能用递归暴力解决，先找递归方法，然后看看哪写步骤重复了，在考虑用个备忘录存起来。
    比如MaximumVacationDays、MinimumSwapToMakeSequencesIncreasing问题

2、列出来基础次数，推导共识，试试能不能找规律。比如变态台阶问题（剑指offer第9题）

3、找规律~~（有点废话）

4、遇到一个数组，相邻的计算，然后数组缩小问题，这种考虑找出关键点，把问题分为两个子链。比如最小矩阵链计算次数，砸金蛋。

5、求最优解：
    a.判断其中一个出现或者没出现在结果集中的题型:CutingARod、KnapsackProblem
    b.列出基本情况，递增找规律，比如小朋友过河时间最短问题。
    c.针对某一个位置的对象分情况讨论，从所有情况中取max或者min，比如EditDistance，EggDroppingPuzzle,LongestCommonSubsequence
        1.针对字符串讨论末尾或者首部字符LongestCommonSubsequence,LongestPalindromicSubsequence
    d.对所有情况去求最值，然后再从所有最值中再求最终，难点在于“所有情况”，这个情况的确定。比如LongestIncreasingSubsequence,LongestBitonicSubsequence

6、求解决方法总数：
    a.判断其中一个出现或者没出现在结果集中的题型:比如BinomialCoefficient,CoinChange
    b.最后一步分情况讨论，比如基础版爬楼梯
  