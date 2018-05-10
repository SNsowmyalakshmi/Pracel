cd E:\Workspaces\Pracelpoint\Testing
set ProjectPath=E:\Workspaces\Pracelpoint\Testing
echo %ProjectPath%
set classpath=%ProjectPath%\bin;%ProjectPath%\lib\*
echo %classpath%
java org.testng.TestNG %ProjectPath%\testng.xml