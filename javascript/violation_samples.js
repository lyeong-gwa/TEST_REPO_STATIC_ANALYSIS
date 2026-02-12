function test_JS_B01(day) {
  switch (day) {
    MONDAY:
      return "Start of week";
    WEDNESDAY:
      return "Midweek";
    FRIDAY:
      return "Almost weekend";
  }
}

function test_JS_C01_no_default(value) {
  switch (value) {
    case 1:
      return "one";
    case 2:
      return "two";
  }
}

function test_JS_C01_default_not_last(value) {
  switch (value) {
    case 1:
      return "one";
    default:
      return "default";
    case 2:
      return "two";
  }
}

function test_JS_C02() {
  for (let i = 0; i < 10; j++) {
    console.log(i);
  }
}

function test_JS_C03() {
  for (let i = 0; i != 10; i += 2) {
    console.log(i);
  }
}

function test_JS_C04(message) {
  console.log("Debug message:", message);
  return message;
}

function test_JS_C05() {
  for (let i = 0; i < 10; i++) {
  }

  if (true) {
  }
}

function test_JS_C06(a, b, a) {
  return a + b;
}

function test_JS_U01() {
  const caller = arguments.caller;
  const callee = arguments.callee;
  return caller;
}

function test_JS_U02(obj) {
  for (let key in obj) {
    console.log(obj[key]);
  }
}

function String(str) {
  return str.toUpperCase();
}

function Array(size) {
  return new Object();
}

function test_JS_U04(arr) {
  for (let i = 0; i < arr.length; i--) {
    console.log(arr[i]);
  }
}

function test_JS_U05(value) {
  if (value > 0) {
    return value;
    value++;
  }
  return 0;
}

function test_JS_U06(arr) {
  for (let i = 0; i < arr.length; i++) {
    function innerFunc() {
      return arr[i];
    }
    innerFunc();
  }
}

const test_JS_U07_obj = {
  _value: 0,
  set value(val) {
    this._value = val;
    return val;
  }
};

function test_JS_U08_if(x) {
  if (x === 1) {
    return "one";
  } else if (x === 2) {
    return "two";
  } else if (x === 1) {
    return "duplicate";
  }
}

function test_JS_U08_switch(x) {
  switch (x) {
    case 1:
      return "first";
    case 2:
      return "second";
    case 1:
      return "duplicate";
  }
}

function test_JS_U09(arr, item) {
  if (arr.indexOf(item) > 0) {
    return true;
  }
  return false;
}

function test_JS_U10(condition) {
  myLabel:
  if (condition) {
    return "labeled if";
  }
}

function test_JS_U11(name, age) {
  name = name;
  age = age;
  return { name, age };
}

function test_JS_U12(a, b) {
  if (a & b) {
    return "both are true";
  }

  if (a | b) {
    return "at least one is true";
  }
}

function test_JS_U13() {
  new Date();
  new Array(10);
  new Object();
}

function test_JS_U14() {
  const package = "my-package";
  const interface = "eth0";
  const private = true;
  return package;
}

function test_JS_U15(x) {
  return (x * 2);
}

function test_JS_U15_complex(a, b) {
  return (a + b);
}

function test_JS_U16(a) {
  if (a == a) {
    return true;
  }

  const result1 = 5 / 5;
  const result2 = 5 - 5;
  const result3 = a === a;

  return result1 + result2;
}

function test_JS_U17(value) {
  if (value === NaN) {
    return "is NaN";
  }

  if (value !== NaN) {
    return "not NaN";
  }
}

function test_JS_U18() {
  var undefined = 1;
  return undefined;
}

function test_JS_U19(param) {
  const unusedVar = 10;
  let anotherUnused = "hello";
  const assignedButUnused = param * 2;

  return "done";
}

function multiple_violations(arr, value) {
  console.log("Starting");

  value = value;

  for (let key in arr) {
    function process(item) {
      return item * 2;
    }

    console.log(process(arr[key]));
  }

  return arr.length;
}
