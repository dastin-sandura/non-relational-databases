// use('nbd')
var mapFunction = function(){
    this.credit.forEach(e => {
        emit(e.currency,Number(e.balance));
    });
//   emit(this.nationality, {
    //   count : 0,
    //   height: Number(this.height),
    //   weight: Number(this.weight)
    // })
};
var reduceFunction = function(currency, balances){
  return Array.sum(balances);
};
var finalizeFunction = function(nationality, reducedValues) {
    reducedValues.avgWeight = reducedValues.weight/reducedValues.count;
    reducedValues.avgHeight = reducedValues.height/reducedValues.count;
    return reducedValues;
}
db.people.mapReduce(
  mapFunction,
  reduceFunction,
  {
    out: "map_reduce_2"
  }
)

printjson(db.map_reduce_2.find().sort( { _id: 1 } ).toArray())