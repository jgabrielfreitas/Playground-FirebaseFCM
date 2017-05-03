curl -X POST -H "Content-Type: application/json" -H "Authorization: key=AIzaSyAMPPstp4QqX5Jl0-4y9N6zOC0DFbaryt4" -H "Cache-Control: no-cache" -H "Postman-Token: d0e8440e-2d10-e2dc-4896-97b550103d44" -d '{ 
	"data": {
    "transactionId": "sdf1sd35fsd1",
    "client": "351468451"
  },
  "notification" : {
  	"body": "corpo da notificação",
  	"title": "teste do título"
  },
  "to" : "c2-CVBzcMPo:APA91bFI422GYUDX4M75iDiKnaYhrdWTgDZHjjxJK6gwXlH-QO5q7iNXfAoNmuvuglZOOUoU_-KCPaY1tGgviQbcXORseFwrozW5JTn3QgRLn7sGgHtwkoBNCG0pSJJIfeuC5v_QyJgN"
}
' "https://fcm.googleapis.com/fcm/send"