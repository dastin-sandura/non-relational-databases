// use('nbd')
var mapFunction = function(){
    this.credit.forEach(e => {
        emit(e.currency,Number(e.balance));
    });
};
var reduceFunction = function(currency, balances){
  return Array.sum(balances);
};
db.people.mapReduce(
  mapFunction,
  reduceFunction,
  {
    out: "map_reduce_2"
  }
)

printjson(db.map_reduce_2.find().sort( { _id: 1 } ).toArray())