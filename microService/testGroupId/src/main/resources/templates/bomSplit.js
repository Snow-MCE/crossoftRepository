/**
 * Created by Snow on 7/26/2017.
 */
//  ------------ 赋值 ------------------------
new Vue({
    el: '#app',
    data: function() {
        return {
            activeName: 'first',
            pickerOptions0: {
                disabledDate(time) {
                    return time.getTime() < Date.now() - 8.64e7;
                }
            },
            formInline: {
                version: '',
                bom:''
            },
            bomComponentDialog: false,
            itemBomSearchDialog:false,
            ItemBomData: _ItemBomList,
            bomForm:{
                bom:'',
                bomDesc:''
            },
            newItemForm: {
                item: '',
                version: '',
                desc: ''
            },
            itemData : _itemDataList,
            bomData : [{
                id:1,
                label: '当前物料清单',
                children: []
            }]
        }
    },
    methods: {
        checkChange(obj,isChecked,children){
            if(isChecked){
                this.$refs.bomTree.setCheckedKeys([]);
                this.$refs.bomTree.setCheckedKeys([obj.id]);
            }
        },
        tableRowClassName(row, index) {
            if (index === 1) {
                return 'info-row';
            } else if (index === 3) {
                return 'positive-row';
            }
            return '';
        },
        remove() {

        },
        showItemComponent(){
            const _serachResultList = [];
            for( var i = 0; i < 10; i++){
                _serachResultList.push(
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
            this.$refs.multipleTable.data = _serachResultList
        },
        load(){
            var me = this;
            var mTable = me.$refs.multipleTable.selection;
            var mtableData = me.$refs.multipleTable.data;
            var treeData = me.$refs.bomTree.data;
            if(mTable.length>0){
                for(var i=0;i<mTable.length;i++){
                    var uid = mTable[i].sequence;
                    var desc = mTable[i].assyItem;
                    // ---- 树形 -------------------
                    var mTree = me.$refs.bomTree.getCheckedNodes();
                    if( mTree.length>0 ){
                        //treeStore.append({ id: uid, label: desc, children: [] }, treeData);
                        var mTreeNode = mTree[0];
                        mTreeNode.children.push ({ id: uid, label: desc, children: [] });
                        var rowId = mTable[i].__ob__.dep.id;
                        mtableData.forEach((row, index)=>{
                            if(index == rowId){
                                alert(row);
                            }
                        })
                    }else{
                        this.$notify.warning({
                            title: '提示',
                            message: '清选择要放置的节点'
                        });
                    }
                }
                me.$refs.multipleTable.clearSelection();
            }else{
                this.$notify.info({
                    title: '消息',
                    message: '清选择要移动的组件',
                    type: 'warning'
                });
            }
        },
        createNewItem(row, event) {
            this.bomComponentDialog=false;
            var item = this.newItemForm.item;
            var version = this.newItemForm.version;
            var desc = this.newItemForm.desc;
            var showDesc = item+"/"+desc
            // ---- 树形 -------------------
            var mTree = this.$refs.bomTree.getCheckedNodes();
            if( mTree.length>0 ){
                var mTreeNode = mTree[0];
                mTreeNode.children.push ({ id: item, label: showDesc, children: [] });
            }else{
                const h = this.$createElement;
                this.$notify({
                    title: '标题名称',
                    message: h('i', { style: 'color: teal'}, '请选择要放置的节点')
                });
            }
        },
        selectedRowBom(row, event) {
            var bom = row.bom;
            var reversion = row.reversion;
            var desc = row.description;
            var endDate = row.endDate;
            this.itemBomSearchDialog=false;
            this.formInline.bom = bom;
            this.formInline.version = reversion;
            this.formInline.description = desc;
            this.formInline.endDate = endDate
        }
    }
})