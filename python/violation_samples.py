def test_python_c01(narg):
    if narg == 1:
        break


def test_python_u01(a, b):
    if a <> b:
        return True
    return False


def test_python_u02():
    x = 10
    # FIXME: This needs to be refactored later
    y = x * 2
    return y


def test_python_u03():
    message = "Hello \world"
    return message


def test_python_u04(a):
    if a == a:
        return True

    result1 = 5 / 5
    result2 = 5 - 5

    return result1 + result2


def test_python_u05(name):
    name = name
    return name


def test_python_u06(b):
    if b == 0:
        return "zero"
    elif b == 0:
        return "also zero"
    else:
        return "not zero"


def test_python_u07(x, y):
    return x + y


def test_python_u08():
    if True: print("hello")

    x = 1; y = 2; z = 3

    return x + y + z


def test_python_u09(y):
    result = ((y / 2)) + 1
    value = (((5 + 3)))
    return result + value


def test_python_u10(a):
    for i in range(a):
        pass

    if a > 0:
        pass


def test_python_u11():
    a = 5
    b = 10
    return a + b


class Foo:
    Foo = ''

    def __init__(self):
        self.value = 0


def test_python_u13(x1, y1, z1, x2, y2, z2):
    return x1 + y1 + z1 + x2 + y2 + z2


def test_python_u14(value):
    if value < 0:
        return -1
    elif value == 0:
        return 0
    elif value < 10:
        return 1
    elif value < 100:
        return 2
    else:
        return 3


def test_python_u15(c1, c2):
    if c1:
        if c2:
            return True
    return False


def test_python_u16(x):
    ++x
    x--
    return x


if __name__ == "__main__":
    print("이 파일은 정적 분석 테스트용 위반 샘플입니다.")
    print("실행을 목적으로 하지 않으며, 여러 문법 오류를 포함하고 있습니다.")
