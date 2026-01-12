
# ヘルスチェック
grpcurl -plaintext localhost:9090 grpc.health.v1.Health.Check

# サービスリスト
grpcurl -plaintext localhost:9090 list

# テスト用
grpcurl -d '{"name":"Hi"}' -plaintext localhost:9090 Sample.ExecuteProcess 

grpcurl -d '{"seconds":"10"}' -plaintext localhost:9090 Sample.Sleep 

#
gradle dependencies

# ローカルへ公開
gradle publishToMavenLocal