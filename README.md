# DataStructure

数据结构的特征

优点  |  缺点

数组：插入块，如果知道下标可以非常快的存取  |  查找慢，删除慢，大小固定

有序数组：比无序的数组查找快  |  删除和插入慢，大小固定

栈：提供后进先出方式的存取  |  存取其他项很慢

队列：提供先进先出方式的存取  |  存取其他项很慢

链表：插入快，删除快  |  查找慢

二叉树：查找、插入、删除都快（如果树保持平衡）  |   删除算法复杂

红-黑树：查找、插入、删除都快（树总是平衡的）  |   算法复杂

2-3-4树：查找、插入、删除都快（树总是平衡的，类似的树队磁盘存储有用）  |   算法复杂

哈希表：如果关键字一直则存取极快，插入快  |  删除慢，如果不知道关键词则存取很慢，对储存空间使用不充分

堆：插入、删除快，对最大数据项的存取很快  |  对其他数据项存取慢

图：对现实世界建模  |  有些算法慢且复杂