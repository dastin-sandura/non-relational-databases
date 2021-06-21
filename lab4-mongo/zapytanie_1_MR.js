// use('nbd')
var mapFunction = function(){
  emit(this.nationality, {
      count : 0,
      height: Number(this.height),
      weight: Number(this.weight)
    })
};
var reduceFunction = function(nationality, heightAndWeightObjects){
    var result = {count:0,height:0,weight:0}
    heightAndWeightObjects.forEach(e => {
      result.count++;
      result.height+=e.height;
      result.weight +=e.weight
    });
  return result;
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
    out: "map_reduce_1",
    finalize:  finalizeFunction
  }
)

printjson(db.map_reduce_1.find().sort( { _id: 1 } ).toArray())