set PR_INSTALL=C:\Programs\metd\${service.name}

%PR_INSTALL% //IS//${windows.application.name} --DisplayName="${windows.application.name}" --Description="Met office weather service in normal mode" ^
    --Install=%PR_INSTALL% ^
    --Startup=auto ^
    --Jvm="C:\Program Files\Java\jdk1.8.0_192\jre\bin\server\jvm.dll" ^
    --Classpath="C:\Programs\metd\lib\${jar.name}.jar" ^
    --StartMode=jvm ^
    --StartClass=com.etlsolutions.examples.weather.ProcrunService ^
    --StartParams="-configFilePath;${config.properties.path}" ^
    --StartMethod=start ^
    --StopMode=jvm ^
    --StopClass=com.etlsolutions.examples.weather.ProcrunService ^
    --StopMethod=stop ^
    --StdOutput="C:\Programs\metd\metdata\log\standout\standout.log" ^
    --StdError="C:\Programs\metd\metdata\log\standerr\standerr.log" 