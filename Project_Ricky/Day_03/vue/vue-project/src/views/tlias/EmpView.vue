<template>
    <div>
        <el-container style="height: 700px; border: 1px solid #eee">
            <el-header style="font-size:40px; background-color: rgb(238, 241, 246)">tlias Intelligent Class Management
                System</el-header>
            <el-container>
                <el-aside width="230px" style="border: 1px solid #eee">
                    <el-menu :default-openeds="['1', '3']">
                        <el-submenu index="1">
                            <template slot="title"><i class="el-icon-message"></i> System Information</template>
                            <el-menu-item index="1-1">
                                <router-link to="/dept">Departments</router-link>
                            </el-menu-item>
                            
                            <el-menu-item index="1-2">
                                <router-link to="/emp">Employees</router-link>
                            </el-menu-item>
                        </el-submenu>
                    </el-menu></el-aside>
                <el-main>
                    <!-- form -->
                    <el-form :inline="true" :model="searchForm" class="demo-form-inline">
                        <el-form-item label="Name">
                            <el-input v-model="searchForm.user" placeholder="Name"></el-input>
                        </el-form-item>

                        <el-form-item label="Gender">
                            <el-select v-model="searchForm.gender" placeholder="Gender">
                                <el-option label="Male" value="1"></el-option>
                                <el-option label="Female" value="2"></el-option>
                            </el-select>
                        </el-form-item>

                        <el-form-item label="EntryDate">
                            <!-- date picker -->
                            <el-date-picker v-model="searchForm.entrydate" type="daterange" range-separator="To"
                                start-placeholder="Start date" end-placeholder="End date">
                            </el-date-picker>
                        </el-form-item>

                        <el-form-item>
                            <el-button type="primary" @click="onSubmit">Query</el-button>
                        </el-form-item>
                    </el-form>

                    <!-- table -->
                    <el-table :data="tableData" border>
                        <el-table-column prop="name" label="Name" width="180"></el-table-column>
                        <el-table-column prop="image" label="Image" width="180"></el-table-column>
                        <el-table-column prop="gender" label="Gender" width="140"></el-table-column>
                        <el-table-column prop="job" label="Job" width="140"></el-table-column>
                        <el-table-column prop="entrydate" label="EntryDate" width="180"></el-table-column>
                        <el-table-column prop="updatetime" label="UpdateTime" width="230"></el-table-column>
                        <el-table-column label="Manage">
                            <el-button type="primary" size="mini">Edit</el-button>
                            <el-button type="danger" size="mini">Delete</el-button>
                        </el-table-column>

                    </el-table>
                    <br>

                    <el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" background
            layout="sizes, prev, pager, next, jumper, total" :total="1000">
        </el-pagination>
                </el-main>
            </el-container>
        </el-container>
    </div>
</template>

<script>
// import axios from 'axios';

export default {
    data() {
        return {
            tableData: [],
            searchForm: {
                name: "",
                gender: "",
                entrydate:[]
            }
        }
    },
    methods: {
        onSubmit: function () {
            alert("Query the data")
        },
        handleSizeChange:function(val){
            alert(val + " records per page!")
        },
        handleCurrentChange:function(val){  
            alert("This page is #" + val)
        }
    },
    // mounted() {
    //     axios.get("http://yapi.smart-xwork.cn/mock/169327/emp/list").then((result) => {
    //         this.tableData = result.data.data;
    //     });
    // },
}
</script>

<style></style>