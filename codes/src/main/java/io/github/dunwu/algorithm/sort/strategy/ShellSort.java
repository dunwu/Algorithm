package io.github.dunwu.algorithm.sort.strategy;

import io.github.dunwu.algorithm.util.ArrayUtil;
import io.github.dunwu.algorithm.sort.Sort;

/**
 * 希尔排序算法
 * @author Zhang Peng
 */
public class ShellSort implements Sort {
    @Override
    public void sort(int[] list) {
        int gap = list.length / 2;

        while (1 <= gap) {
            // 把距离为 gap 的元素编为一个组，扫描所有组
            for (int i = gap; i < list.length; i++) {
                int j = 0;
                int temp = list[i];

                // 对距离为 gap 的元素组进行排序
                for (j = i - gap; j >= 0 && temp < list[j]; j = j - gap) {
                    list[j + gap] = list[j];
                }
                list[j + gap] = temp;
            }

            ArrayUtil.debugLogArray(list, 0, list.length - 1, String.format("gap = %d:", gap));
            // 减小增量
            gap = gap / 2;
        }
    }
}
