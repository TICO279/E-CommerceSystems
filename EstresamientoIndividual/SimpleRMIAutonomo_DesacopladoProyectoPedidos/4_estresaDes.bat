echo off
echo ejecuta el estresador para sembrar los clientes
echo uso:
echo 4_estresa NumCltes NumSolicitudesPorClte HOSTNAME (en caso de omitirlo se usa localhost, si se omiten los clientes usa 15 y el localhost)
echo on

rem ==============================================================
rem Definicion de roles de jars para ejecucion
rem ==============================================================


set cb=%cd%\tstRMI_desacoplado_ProyectoPedidos.jar
set JAR_INTERFAZ=ISolicitaServicio.jar
set JAR_CLTE_ESTRES=Pojo_EnviosProy.jar
set POJO_ESTRES=Clte_des

rem ==============================================================
rem Consolidacion del classpath
rem ==============================================================

set clpt=%cb%;%JAR_INTERFAZ%;%JAR_CLTE_ESTRES%


if [%1] NEQ [] goto conclientes
estresador 3 -Djava.rmi.server.codebase=file:%cb% -cp %clpt% example.hello.Distribuidor %POJO_ESTRES% localhost 1
goto fin

:conclientes

if [%2] NEQ [] goto consolicitudes
estresador %1 -Djava.rmi.server.codebase=file:%cb% -cp %clpt% example.hello.Distribuidor %POJO_ESTRES% localhost 3
goto fin

:consolicitudes
if [%3] NEQ [] goto conHost
estresador %1 -Djava.rmi.server.codebase=file:%cb% -cp %clpt% example.hello.Distribuidor %POJO_ESTRES% localhost %2
goto fin

:conHost
estresador %1 -Djava.rmi.server.codebase=file:///%cb% -cp %clpt% example.hello.Distribuidor %POJO_ESTRES% %3 %2


:fin