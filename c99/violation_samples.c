#include <stdio.h>
#include <stdlib.h>
#include <stdarg.h>
#include <string.h>
#include <stdbool.h>
#include <unistd.h>

int* test_C99_B01(void) {
    int x = 5;
    return &x;
}

void test_C99_B02(void) {
    int* ptr = (int*)malloc(sizeof(int) * 100);
    *ptr = 42;
}

void test_C99_B03(void) {
    char buf1[];
    char buf2[10];
}

void test_C99_B04(void) {
    FILE* fp = fopen("test.txt", "r");
    if (fp != NULL) {
        fclose(fp);
        fgetc(fp);
    }
}

void test_C99_C01(void) {
    int pipefd[1];
    pipe(pipefd);
}

void test_C99_C02(void) {
    char buf[100] = "hello";
    sprintf(buf, "%s world", buf);
}

void test_C99_C03(int count, ...) {
    va_list args;
    va_start(args, count);
    int val = va_arg(args, int);
}

void test_C99_C04(int count, ...) {
    va_list args;
    va_end(args);
}

void test_C99_C05(void) {
    const char* str = "12345";
    char* endptr;
    long val = strtol(str, &endptr, 40);
}

typedef struct {
    int value;
} NotAFunction;

void test_C99_C06(void) {
    NotAFunction(123);
}

void test_C99_C07(void) {
    char a[20];
    memset(a, 0, sizeof(a) != 12);
}

void test_C99_C08(int count, ...) {
    va_list args;
    va_start(args, count);
    va_start(args, count);
    va_end(args);
}

struct AB {
    int a;
    int b;
};

void test_C99_C09(void) {
    struct AB ab;
    int a = ab.a;
}

void test_C99_C10(int* count, ...) {
    va_list args;
    va_start(args, *count);
    va_end(args);
}

void test_C99_C11(void) {
    const char* original = "test string";
    char* copy = strdup(original);
    printf("%s\n", copy);
}

void test_C99_C12(void) {
    FILE* fp = fopen("test.txt", "w");
    if (fp != NULL) {
        fgetc(fp);
        fclose(fp);
    }
}

void test_C99_C13(void) {
    FILE* fp = fopen("test.txt", "w+");
    if (fp != NULL) {
        char buf[10] = "hello";
        fwrite(buf, 1, 5, fp);
        fread(buf, 1, 5, fp);
        fclose(fp);
    }
}

void test_C99_C14(void) {
    FILE* fp = fopen("test.txt", "r");
    if (fp != NULL) {
        fprintf(fp, "test");
        fclose(fp);
    }
}

int global_before_include = 1;

#if defined(X > Y)
#define TEST_U02 1
#endif

void test_C99_U03(void) {
    int* arr = (int*)calloc(10, 4);
    free(arr);
}

#define MM(define) define + 1

int main(void) {
    printf("This file contains 22 C99 rule violations for static analysis testing.\n");
    printf("DO NOT COMPILE OR EXECUTE THIS CODE.\n");
    return 0;
}
