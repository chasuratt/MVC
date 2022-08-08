curl -i -X POST -H 'Content-Type: application/json' http://localhost:2525/imposters --data '{
  "port": 4545,
   "protocol": "http",
   "stubs": [
     {
       "responses": [
         {
           "is": { "body": {"message":"This is MounteBank Payload Just some message"} },
           "behaviors": [
             { "wait": 2000  }
           ]
         }
       ]
     }
   ]
 }'