/**
 * Created by Snow on 7/26/2017.
 */


const _itemDataList = [];
for( var i = 0; i < 10; i++){
    _itemDataList.push(
        Mock.mock({
            "sequence": Mock.mock('@increment(10)'),
            "assyItem": Mock.mock('@cword(3)')+"/A",
            "assyOper": Mock.mock('@cword(3)'),
            "testPart": Mock.mock('@cword(3)'),
            "assyQty":  Mock.mock('@float(0, 50, 3, 5)'),
            "measure|1": ["KG","M","L","g","KM"],
            "assyType": Mock.mock('@cword(3)')
        })
    );
}

const _ItemBomList = [];
for( var i = 0; i < 20; i++){
    _ItemBomList.push(
        Mock.mock({
            "bom": Mock.mock('@string("upper", 4, 6)'),
            "description":Mock.mock('@ctitle(3, 5)'),
            "reversion": Mock.mock('@cword("ABCD", 1)'),
            "endDate": Mock.mock('@date')
        })
    );
}

const userInfra =  Mock.mock({
    "name":Mock.Random.cname(),
    "e_mail":Mock.Random.email(),
    "status|1":["生效","作废"],
    "date_effect":Mock.Random.date('yyyy-MM-dd'),
    "date_expire":Mock.Random.date('yyyy-MM-dd')
})
