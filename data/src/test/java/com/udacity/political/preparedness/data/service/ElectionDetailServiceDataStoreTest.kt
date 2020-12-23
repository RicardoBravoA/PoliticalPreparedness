package com.udacity.political.preparedness.data.service

import com.udacity.political.preparedness.data.repository.ElectionLocalDataRepositoryTest
import com.udacity.political.preparedness.data.util.MainCoroutineRule
import com.udacity.political.preparedness.domain.model.DivisionModel
import com.udacity.political.preparedness.domain.model.ElectionModel
import com.udacity.political.preparedness.domain.util.ResultType
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import org.hamcrest.core.IsEqual
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import java.util.*
import kotlin.collections.LinkedHashMap

@ExperimentalCoroutinesApi
class ElectionDetailServiceDataStoreTest {

    private val item0 =
        ElectionModel("0", "Name 0", Date(), DivisionModel("0", "Country 0", "State 0"))
    private val item1 =
        ElectionModel("1", "Name 1", Date(), DivisionModel("1", "Country 1", "State 1"))
    private val item2 =
        ElectionModel("2", "Name 2", Date(), DivisionModel("0", "Country 2", "State 2"))
    private val list = LinkedHashMap<String, ElectionModel>()
    private val result = listOf(item0, item1, item2)

    // Class under test
    private lateinit var repository: ElectionLocalDataRepositoryTest

    @ExperimentalCoroutinesApi
    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun createRepository() {
        list["0"] = item0
        list["1"] = item1
        list["2"] = item2
        repository = ElectionLocalDataRepositoryTest(list)
    }

    @Test
    fun getElections_requestsAllelectionsFromRemoteDataRepository() =
        mainCoroutineRule.runBlockingTest {
            val election = repository.get() as ResultType.Success
            Assert.assertThat(election.value, IsEqual(result))
        }

}