package ru.veselov.warmup;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class TaskATest {

    public static final String NOT_FOUND = "NOT FOUND";

    @Test
    void shouldPass() {
        TaskA taskA = new TaskA();
        int[] array = new int[]{1, 1, 1, 1, 1, 1, 2, 1, 1, 1};
        String s = taskA.checkInterval(array, 6, 8);

        Assertions.assertThat(s).isEqualTo("2");
    }

}