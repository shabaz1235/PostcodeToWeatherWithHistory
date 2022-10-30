# Get weather forecast from post code

An interactive CLI prompt using Yahoo! Open Local Platform.  
Input postcode to get weather forecast of next hours. Geted weather forecast will be saved in local sqlite db, and can be queried or cleared by command.  

Aimed to practice API caling, basic CRUD operations and error handling in java.



# 郵便番号から天気予報を取得

対話モードで使用するCLIツールです、使用するAPIはYahoo! Open Local Platform。  
郵便番号を入力して、今から一時間以内の天気予報が表示されます。  
表示された天気予報は、ローカルのSQLiteデータベースに保存され、照会、クリア操作が出来ます。

APIの使用、DBの基本操作、エラー処理の練習を目標しています。

実行例:

```
>Please input zipcode in the format of 000-0000, or history, clear, quit:

history

+-----------+---------------+----------+
| 郵便番号    | 時間           | 降水確率  |
+-----------+---------------+----------+
+-----------+---------------+----------+
>Please input zipcode in the format of 000-0000, or history, clear, quit:

627-0004

+-----------------------------------+
| 京都府京丹後市峰山町荒山                  |
+-----------------+-----------------+
| 時間             | 降水確率         |
+-----------------+-----------------+
| 202210301550    | 0.000000        |
| 202210301600    | 0.000000        |
| 202210301610    | 0.000000        |
| 202210301620    | 0.000000        |
| 202210301630    | 0.000000        |
| 202210301640    | 0.000000        |
| 202210301650    | 0.000000        |
+-----------------+-----------------+
>Please input zipcode in the format of 000-0000, or history, clear, quit:

001-8555

+-----------------------------------+
| 北海道札幌市北区北十五条西５丁目１番５号          |
+-----------------+-----------------+
| 時間             | 降水確率         |
+-----------------+-----------------+
| 202210301550    | 0.000000        |
| 202210301600    | 0.000000        |
| 202210301610    | 0.000000        |
| 202210301620    | 0.000000        |
| 202210301630    | 0.000000        |
| 202210301640    | 0.000000        |
| 202210301650    | 0.000000        |
+-----------------+-----------------+
>Please input zipcode in the format of 000-0000, or history, clear, quit:

history

+-----------+---------------+----------+
| 郵便番号    | 時間           | 降水確率  |
+-----------+---------------+----------+
| 001-8555  | 202210301650  | 0.0      |
| 627-0004  | 202210301650  | 0.0      |
+-----------+---------------+----------+
>Please input zipcode in the format of 000-0000, or history, clear, quit:

clear

>Please input zipcode in the format of 000-0000, or history, clear, quit:

history

+-----------+---------------+----------+
| 郵便番号    | 時間           | 降水確率  |
+-----------+---------------+----------+
+-----------+---------------+----------+
>Please input zipcode in the format of 000-0000, or history, clear, quit:

quit

Process finished with exit code 0
```
