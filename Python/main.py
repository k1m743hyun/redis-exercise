import redis

r = redis.Redis('localhost')
print(r.ping())

d = {'1': 'hello', '2': 'world'}
r.set('test', str(d))

result = r.get('test')
print(result)

s = eval(result)
print(s)