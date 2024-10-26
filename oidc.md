# OIDC
Ci dessous les différentes requêtes pour récupérer des tokens
## Login
```shell
curl --location --request POST 'http://localhost:8080/auth/realms/tindeer/protocol/openid-connect/token' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'username=toto' \
--data-urlencode 'password=toto' \
--data-urlencode 'grant_type=password' \
--data-urlencode 'client_id=tindeer' \
--data-urlencode 'client_secret=52ea707a-eeeb-4962-8c0d-b854b76e2fc5'
```

## Userinfo
```shell
curl --location --request GET 'http://localhost:8080/auth/realms/tindeer/protocol/openid-connect/userinfo' \
--header "Authorization: Bearer eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPSHZKZWZrQk1OazU2M1VidW14QzIySVprak5DQTZadXp0WkZzMmNCam1rIn0.eyJleHAiOjE2MzQ4MjgxMDMsImlhdCI6MTYzNDgyNzgwMywianRpIjoiNTY2NDM3N2UtZjU5OS00YjkzLTlkYzEtYTZlMGU1NWQxMGM0IiwiaXNzIjoiaHR0cDovL2xvY2FsaG9zdDo4MDgwL2F1dGgvcmVhbG1zL3RpbmRlZXIiLCJhdWQiOiJhY2NvdW50Iiwic3ViIjoiNWM4NTQzNzMtMGIzYS00NTk5LWE1YmQtNmI0MWEzMjk5NDM5IiwidHlwIjoiQmVhcmVyIiwiYXpwIjoidGluZGVlciIsInNlc3Npb25fc3RhdGUiOiJjYTU4YTNiOC1lN2NhLTRhNGYtYjQ1Yi04MTg2NTc0ODEyZDYiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbImRlZmF1bHQtcm9sZXMtdGluZGVlciIsIm9mZmxpbmVfYWNjZXNzIiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6ImVtYWlsIHByb2ZpbGUiLCJzaWQiOiJjYTU4YTNiOC1lN2NhLTRhNGYtYjQ1Yi04MTg2NTc0ODEyZDYiLCJlbWFpbF92ZXJpZmllZCI6dHJ1ZSwicHJlZmVycmVkX3VzZXJuYW1lIjoidG90byIsImVtYWlsIjoidG90b0B5b3BtYWlsLmNvbSJ9.bZdLbLW_A5_ofJDcgpNIva2Nw3rha51hg7Psb7jlxXq-uVuwiQcDQV-t8RLvZ9k2yalyA2NXP9RquaIeZKXyeXggtopQp9nqTlEfB2Fj5YTxZ2Wf-jiDFfkShP-Zijsn6Sl6XbrBWTOUMvnWYZKZm0qnMQMrxqjOL1UL4SPxk0ypJjlQHodv7X_J_9bf29CCyzoiXJmod3sLxtUDBOdDipcKduC1ga8CM4UJh7N5-p2-repv8SKAghNoL5xkz2ilYr5gskHvLcu14yUCcwoMXY4R7heY1xBa5gI-MGEndy_YrZJZqTpEC7t6Ae9Aa73rVboYM-MMGOjgWBfaBIRZrw"
```

## Token info
```shell
curl --location --request POST 'http://localhost:8080/auth/realms/tindeer/protocol/openid-connect/token/introspect' \
--header 'Authorization: Bearer XXXXXXXX' \
--header 'Content-Type: application/x-www-form-urlencoded' \
--data-urlencode 'client_id=tindeer' \
--data-urlencode 'client_secret=a0f53195-8135-45af-b09c-954196a88ad0' \
--data-urlencode 'token=XXXXXXXX'
```