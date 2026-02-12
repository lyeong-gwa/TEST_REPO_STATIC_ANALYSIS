using System;
using System.Data.SqlClient;
using System.IO;
using System.Net.Sockets;
using System.Threading;

namespace DummyProject.ViolationSamples
{
    public class CSharpB01
    {
        private string password = "Admin123";
        private string apiKey = "sk-1234567890abcdef";
        private string connectionString = "Server=myServer;Database=myDB;User Id=admin;Password=P@ssw0rd123;";

        public void Login()
        {
            string pwd = "SuperSecret2024!";
            string token = "ghp_16C7e42F292c6912E7710c838347Ae178B4a";
        }
    }

    public class CSharpB02
    {
        public void DangerousThreadControl()
        {
            Thread workerThread = new Thread(DoWork);
            workerThread.Start();

            workerThread.Suspend();

            workerThread.Abort();
        }

        private void DoWork()
        {
            while (true)
            {
                Console.WriteLine("Working...");
                Thread.Sleep(1000);
            }
        }
    }

    public class CSharpC01
    {
        public void WrongExceptionOrder()
        {
            try
            {
                string content = File.ReadAllText("test.txt");
                int number = int.Parse(content);
            }
            catch (Exception ex)
            {
                Console.WriteLine("General error: " + ex.Message);
            }
            catch (FileNotFoundException ex)
            {
                Console.WriteLine("File not found");
            }
            catch (FormatException ex)
            {
                Console.WriteLine("Format error");
            }
        }
    }

    public class CSharpC02
    {
        public int ReturnInFinally()
        {
            try
            {
                return 1;
            }
            catch (Exception ex)
            {
                return 2;
            }
            finally
            {
                return 3;
            }
        }

        public string AnotherExample()
        {
            try
            {
                throw new Exception("Error");
            }
            finally
            {
                return "Done";
            }
        }
    }

    public class CSharpC03
    {
        public void ForceGarbageCollection()
        {
            GC.Collect();
            GC.WaitForPendingFinalizers();
            GC.Collect();

            DoSomeWork();

            GC.Collect(2, GCCollectionMode.Forced);
        }

        private void DoSomeWork()
        {
            byte[] data = new byte[1024 * 1024];
        }
    }

    public class CSharpC04
    {
        public void NestedTryBlocks()
        {
            try
            {
                Console.WriteLine("Outer try");

                try
                {
                    Console.WriteLine("Inner try");

                    try
                    {
                        int result = 10 / 0;
                    }
                    catch (Exception ex)
                    {
                        Console.WriteLine("Inner inner catch");
                    }
                }
                catch (Exception ex)
                {
                    Console.WriteLine("Inner catch");
                }
            }
            catch (Exception ex)
            {
                Console.WriteLine("Outer catch");
            }
        }
    }

    public class CSharpC05
    {
        public void DatabaseWithoutClose()
        {
            SqlConnection connection = new SqlConnection("Server=localhost;Database=TestDB;");
            connection.Open();

            SqlCommand command = new SqlCommand("SELECT * FROM Users", connection);
            SqlDataReader reader = command.ExecuteReader();

            while (reader.Read())
            {
                Console.WriteLine(reader["Name"]);
            }
        }

        public void AnotherExample()
        {
            SqlConnection conn = new SqlConnection("Server=.;Database=MyDB;");
            conn.Open();
            ExecuteSomeQuery(conn);
        }

        private void ExecuteSomeQuery(SqlConnection conn)
        {
            throw new Exception("Query failed");
        }
    }

    public class CSharpC06
    {
        public void FileStreamWithoutClose()
        {
            FileStream fs = new FileStream("test.txt", FileMode.Open);
            byte[] buffer = new byte[1024];
            fs.Read(buffer, 0, buffer.Length);
        }

        public void MultipleStreams()
        {
            FileStream input = File.OpenRead("input.txt");
            FileStream output = File.OpenWrite("output.txt");

            byte[] data = new byte[1024];
            int bytesRead = input.Read(data, 0, data.Length);
            output.Write(data, 0, bytesRead);
        }
    }

    public class CSharpC07
    {
        public void SocketWithoutClose()
        {
            Socket socket = new Socket(AddressFamily.InterNetwork, SocketType.Stream, ProtocolType.Tcp);
            socket.Connect("localhost", 8080);

            byte[] data = System.Text.Encoding.UTF8.GetBytes("Hello");
            socket.Send(data);
        }

        public void TcpClientExample()
        {
            TcpClient client = new TcpClient();
            client.Connect("127.0.0.1", 9000);
            NetworkStream stream = client.GetStream();

            byte[] message = System.Text.Encoding.ASCII.GetBytes("Test");
            stream.Write(message, 0, message.Length);
        }
    }

    public class CSharpC08
    {
        public void InfiniteLoopWithoutBreak()
        {
            while (true)
            {
                Console.WriteLine("Running forever...");
                Thread.Sleep(1000);
            }
        }

        public void AnotherInfiniteLoop()
        {
            int counter = 0;
            while (true)
            {
                counter++;
                DoSomething(counter);
            }
        }

        private void DoSomething(int value)
        {
            Console.WriteLine(value);
        }
    }

    public class CSharpU01
    {
        public void FunctionCallInLoopCondition()
        {
            string[] items = { "a", "b", "c", "d", "e" };

            for (int i = 0; i < GetLength(items); i++)
            {
                Console.WriteLine(items[i]);
            }

            for (int j = 0; j < CalculateComplexValue(); j++)
            {
                DoWork();
            }
        }

        private int GetLength(string[] array)
        {
            Console.WriteLine("GetLength called");
            return array.Length;
        }

        private int CalculateComplexValue()
        {
            return new Random().Next(100);
        }

        private void DoWork()
        {
            Thread.Sleep(10);
        }
    }

    public class CSharpU02
    {
        public void EmptyFinallyBlock()
        {
            try
            {
                int result = 10 / 2;
                Console.WriteLine(result);
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }
            finally
            {
            }
        }

        public void AnotherExample()
        {
            try
            {
                File.ReadAllText("data.txt");
            }
            finally
            {
            }
        }
    }

    public class CSharpU03
    {
        public void EmptyIfBlock(int value)
        {
            if (value > 0)
            {
            }
            else
            {
                Console.WriteLine("Negative or zero");
            }

            if (value == 100)
            {
            }

            string name = "test";
            if (name.Length > 0)
            {
            }
        }
    }

    public class CSharpU04
    {
        public void EmptyWhileBlock()
        {
            int counter = 0;

            while (counter < 10)
            {
            }

            bool isRunning = true;
            while (isRunning)
            {
            }
        }
    }

    public class CSharpU05
    {
        public void EmptySwitchBlock(int option)
        {
            switch (option)
            {
            }

            string command = "start";
            switch (command)
            {
            }
        }
    }

    public class CSharpU06
    {
        public void EmptyTryBlock()
        {
            try
            {
            }
            catch (Exception ex)
            {
                Console.WriteLine("Error: " + ex.Message);
            }

            try
            {
            }
            catch (IOException ex)
            {
                Console.WriteLine("IO Error");
            }
        }
    }

    public class CSharpU07
    {
        public void ForLoopWithoutTermination()
        {
            for (;;)
            {
                Console.WriteLine("Infinite loop");
                Thread.Sleep(500);
            }
        }

        public void AnotherInfiniteFor()
        {
            int count = 0;
            for (; ;)
            {
                count++;
                if (count > 1000000)
                {
                    break;
                }
            }
        }
    }

    public class CSharpU08
    {
        public void PublicMethod()
        {
            Console.WriteLine("Public method called");
        }

        private void UnusedPrivateMethod()
        {
            Console.WriteLine("This is never called");
        }

        private int CalculateValue(int x, int y)
        {
            return x * y + 10;
        }

        private string FormatData(string input)
        {
            return input.ToUpper().Trim();
        }
    }

    public class CSharpU09
    {
        public void MethodWithUnusedParam(int usedParam, string unusedParam)
        {
            Console.WriteLine("Value: " + usedParam);
        }

        public int Calculate(int a, int b, int c, int d)
        {
            return a + b;
        }

        private void DoNothing(string param1, int param2, bool param3)
        {
            Console.WriteLine("Doing nothing");
        }
    }

    public class CSharpU10
    {
        private int unusedCounter;
        private string unusedName;
        private bool unusedFlag = false;
        private double unusedValue = 3.14;

        private int usedField;

        public void SomeMethod()
        {
            usedField = 10;
            Console.WriteLine(usedField);
        }

        private readonly string unusedConstant = "UNUSED";
        private static int unusedStatic = 100;
    }

    public class CSharpU11
    {
        public void ModifyLoopVariable()
        {
            for (int i = 0; i < 10; i++)
            {
                Console.WriteLine(i);
                i++;
            }

            for (int j = 0; j < 100; j++)
            {
                if (j % 2 == 0)
                {
                    j += 5;
                }
                Console.WriteLine(j);
            }
        }

        public void AnotherExample()
        {
            for (int k = 0; k < 50; k++)
            {
                DoWork();
                k = k * 2;
            }
        }

        private void DoWork()
        {
            Thread.Sleep(10);
        }
    }

    public class CSharpU12
    {
        public void ForLoopEmptyCondition()
        {
            for (int i = 0; ; i++)
            {
                if (i > 10)
                    break;
                Console.WriteLine(i);
            }

            int j = 0;
            for (; ; j++)
            {
                if (j >= 20)
                    break;
                DoSomething(j);
            }
        }

        private void DoSomething(int value)
        {
            Console.WriteLine("Value: " + value);
        }
    }

    public class CSharpU13
    {
        public void SwitchWithoutBreak(int option)
        {
            switch (option)
            {
                case 1:
                    Console.WriteLine("Option 1");
                case 2:
                    Console.WriteLine("Option 2");
                case 3:
                    Console.WriteLine("Option 3");
                    break;
                default:
                    Console.WriteLine("Default");
            }
        }

        public void AnotherSwitchExample(string command)
        {
            switch (command)
            {
                case "start":
                    Console.WriteLine("Starting...");
                case "stop":
                    Console.WriteLine("Stopping...");
                case "pause":
                    Console.WriteLine("Pausing...");
                case "resume":
                    Console.WriteLine("Resuming...");
                    break;
            }
        }
    }
}
