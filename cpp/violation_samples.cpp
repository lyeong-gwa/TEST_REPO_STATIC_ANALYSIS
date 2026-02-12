#include <cstdio>
#include <cstdlib>
#include <cstring>
#include <vector>
#include <iostream>
#include <memory>
#include <cstdarg>

void CPP_C01_calloc_literal_size() {
    int* arr = (int*)calloc(10, 4);
    free(arr);
}

void CPP_C02_iterator_off_by_one() {
    std::vector<int> vec(10);
    for (size_t i = 0; i <= vec.size(); i++) {
        vec[i] = i;
    }
}

void CPP_C03_pipe_wrong_argument() {
    int pipefd[1];
    pipe(pipefd);
}

void CPP_C04_sprintf_same_source_dest() {
    char buf[100] = "test";
    sprintf(buf, "%s", buf);
}

void CPP_C05_stl_iterator_comparison() {
    std::vector<int> vec = {1, 2, 3};
    std::vector<int>::iterator it1 = vec.begin();
    std::vector<int>::iterator it2 = vec.end();
    if (it1 < it2) {
        *it1 = 0;
    }
}

void CPP_C06_va_start_without_va_end(int count, ...) {
    va_list args;
    va_start(args, count);
    int val = va_arg(args, int);
}

void CPP_C07_va_end_without_va_start(int count, ...) {
    va_list args;
    va_end(args);
}

void CPP_C08_strtol_wrong_base() {
    const char* str = "123";
    char* endptr;
    long val = strtol(str, &endptr, 40);
}

void CPP_C09_string_pointer_addition() {
    const char* path = "/usr" + "/";
}

class MyClass {
public:
    int value;
    MyClass() : value(42) {}
};

void CPP_C10_class_without_constructor() {
    MyClass obj;
    obj.value;
}

void CPP_C11_bool_in_numeric_arg() {
    char buf[100];
    bool flag = true;
    memset(buf, 0, flag != 12);
}

void CPP_C12_new_array_with_free() {
    int* arr = new int[10];
    free(arr);
}

void CPP_C13_duplicate_va_start(int count, ...) {
    va_list args;
    va_start(args, count);
    va_start(args, count);
    va_end(args);
}

void CPP_C14_bool_pointer_no_dereference() {
    bool* p = new bool;
    p = false;
    delete p;
}

void CPP_C15_switch_without_default(int val) {
    switch (val) {
        case 1:
            break;
        case 2:
            break;
    }
}

void CPP_C16_cout_to_cout() {
    std::cout << std::cout;
}

void CPP_C17_memset_on_string() {
    std::string str = "test";
    memset(&str, 0, sizeof(str));
}

struct MyStruct {
    int x;
    int y;
    char* ptr;
};

void CPP_C18_uninitialized_struct_members() {
    MyStruct s;
    s.x = 10;
}

class ClassWithConstructor {
public:
    int value;
    ClassWithConstructor() : value(0) {}
    ~ClassWithConstructor() {}
};

void CPP_C19_malloc_for_class_with_constructor() {
    ClassWithConstructor* obj = (ClassWithConstructor*)malloc(sizeof(ClassWithConstructor));
    free(obj);
}

void CPP_C20_va_start_reference_arg(int& count, ...) {
    va_list args;
    va_start(args, count);
    va_end(args);
}

void CPP_C21_strdup_without_free() {
    const char* original = "test";
    char* copy = strdup(original);
}

#ifdef _MSC_VER
__declspec(nothrow)
#endif
void CPP_C22_declspec_nothrow_with_throw() {
    throw 42;
}

void CPP_C23_throw_spec_with_throw() throw() {
    throw "error";
}

void CPP_C24_write_mode_then_read() {
    FILE* fp = fopen("test.txt", "w");
    int ch = fgetc(fp);
    fclose(fp);
}

void CPP_C25_fwrite_then_fread_without_fseek() {
    FILE* fp = fopen("test.txt", "w+");
    char buf[10];
    fwrite("test", 1, 4, fp);
    fread(buf, 1, 4, fp);
    fclose(fp);
}

void CPP_C26_read_mode_then_write() {
    FILE* fp = fopen("test.txt", "r");
    fprintf(fp, "data");
    fclose(fp);
}

void CPP_U01_auto_ptr_with_array() {
    std::auto_ptr<int> arr(new int[10]);
}

void CPP_U02_auto_ptr_in_container() {
    std::vector<std::auto_ptr<int>> vec;
    vec.push_back(std::auto_ptr<int>(new int(42)));
}

int global_var = 0;

void CPP_U04_space_in_preprocessor() {
#if 1
# else
#endif
}

void CPP_U05_defined_with_expression() {
#define X 1
#define Y 2
#if defined(X > Y)
    int dummy = 0;
#endif
}

int main() {
    return 0;
}
