#二叉堆的介绍
二叉堆是完全二元树或者是近似完全二元树，按照数据的排列方式可以分为两种：最大堆和最小堆。
最大堆：父结点的键值总是大于或等于任何一个子节点的键值；最小堆：父结点的键值总是小于或等于任何一个子节点的键值。

二叉堆一般都通过"数组"来实现，下面是数组实现的最大堆和最小堆的示意图

#二叉堆的图文解析
图文解析是以"最大堆"来进行介绍的。
最大堆的核心内容是"添加"和"删除"，理解这两个算法，二叉堆也就基本掌握了。下面对它们进行介绍，其它内容请参考后面的完整源码。

1. 添加

假设在最大堆[90,80,70,60,40,30,20,10,50]种添加85，需要执行的步骤如下：heapadd.jpg
如上图所示，当向最大堆中添加数据时：先将数据加入到最大堆的最后，然后尽可能把这个元素往上挪，直到挪不动为止！
将85添加到[90,80,70,60,40,30,20,10,50]中后，最大堆变成了[90,85,70,60,80,30,20,10,50,40]。

2. 删除

假设从最大堆[90,85,70,60,80,30,20,10,50,40]中删除90，需要执行的步骤如下：
如上图所示，当从最大堆中删除数据时：先删除该数据，然后用最大堆中最后一个的元素插入这个空位；接着，把这个“空位”尽量往上挪，直到剩余的数据变成一个最大堆。
从[90,85,70,60,80,30,20,10,50,40]删除90之后，最大堆变成了[85,80,70,60,40,30,20,10,50]。