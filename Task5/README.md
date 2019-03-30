###Предустановленное ПО
- Docker

###Установка
0. Включить Docker
0. Скачать последнию версию **Configuration Manager** c [GitHub](https://github.com/aerokube/cm/releases)
0. Скачать последнию версию **Selenoid** c [GitHub](https://github.com/aerokube/selenoid/releases/)
0. Создать папку **config**
0. В папке **config** создать файл **browsers.json** с содержимым:
```
{
    "opera": {
    "versions": {
      "58.0": {
        "image": "selenoid/vnc:opera_58.0",
        "port": "4444"
      }
    }
  },
  "firefox": {
    "versions": {
      "66.0": {
        "image": "selenoid/vnc:firefox_66.0",
        "port": "4444"
      }
    }
  },
  "chrome": {
    "versions": {
      "73.0": {
        "image": "selenoid/vnc:chrome_73.0",
        "port": "4444"
      }
    }
  }
}
```
6 Выполнить команды для получение образов
```
docker pull selenoid/vnc:opera_58.0
docker pull selenoid/vnc:firefox_66.0
docker pull selenoid/vnc:chrome_73.0
```

7 Выполнить команду `cm.exe selenoid start`

На экраны должны увидеть подобное
```
> Using Docker
- Your Docker API version is 1.39
> Selenoid is already downloaded
> Selenoid is already configured
> Selenoid is already running
```

8 Включить selenoid командой: `selenoid.exe start --vnc`

9 В папке source выполнить: `gradle all`, что-бы запустить тесты