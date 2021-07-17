<?php
class Query
{
	private $sv;
	private $table;
	private $alias;
	private $whereArray = [];
	private $operators = [];
	private $joinArray = [];
	private $groups = [];
	private $orders = [];
	
	
	public function From($table, $alias = false)
	{
		$this->table = $table;
		$this->alias = $alias;
		return $this;
	}
	
	public function As($alias = false)
	{
		$this->alias = $alias;
		return $this;
	}
	
	public function Select($object)
	{
		$this->sv = $this->ToArray($object);
		return $this;
	}
	
	public function Where($object)
	{
		$this->whereArray = $this->ToArray($object);
		return $this;
	}
	
	public function And()
	{
		$this->operators[] = " AND ";
		return $this;
	}
	
	public function Or()
	{
		$this->operators[] = " OR ";
		return $this;
	}
	
	public function eq($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " = ";
		$obj->key = $key;
		$obj->value = $value;
		$this->AddClause($obj);
		return $this;
	}
	
	public function ge($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " >= ";
		$obj->key = $key;
		$obj->value = $value;
		$this->AddClause($obj);
		return $this;
	}
	
	public function gt($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " >= ";
		$obj->key = $key;
		$obj->value = $value;
		$this->AddClause($obj);
		return $this;
	}
	
	public function le($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " <= ";
		$obj->key = $key;
		$obj->value = $value;
		$this->AddClause($obj);
		return $this;
	}

	public function lt($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " < ";
		$obj->key = $key;
		$obj->value = $value;
		$this->AddClause($obj);
		return $this;
	}
	
	public function ne($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " <> ";
		$obj->key = $key;
		$obj->value = $value;
		$this->AddClause($obj);
		return $this;
	}
	
	public function Like($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " LIKE ";
		$obj->key = $key;
		$obj->value ="'%".$value."%'";
		$this->AddClause($obj);
		return $this;
	}
	
	public function Starts($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " LIKE ";
		$obj->key = $key;
		$obj->value ="'".$value."%'";
		$this->AddClause($obj);
		return $this;
	}
	
	public function Ends($key, $value)
	{
		$obj = new stdClass;
		$obj->operator = " LIKE ";
		$obj->key = $key;
		$obj->value ="'%".$value."'";
		$this->AddClause($obj);
		return $this;
	}

	public function InnerJoin($tbl, $src, $tar, $alias = false)
	{
		$obj = new stdClass;
		$obj->type = "inner join";
		$obj->table = $tbl;
		$obj->source = $src;
		$obj->target = $tar;
		$obj->alias = $alias;
		$this->joinArray[] = $obj;
		return $this;
	}
	
	public function LeftJoin($tbl, $src, $tar, $alias = false)
	{
		$obj = new stdClass;
		$obj->type = "left join";
		$obj->table = $tbl;
		$obj->source = $src;
		$obj->target = $tar;
		$obj->alias = $alias;
		$this->joinArray[] = $obj;
		return $this;
	}
	
	public function OrderBy($object)
	{
		$this->orders = $this->ToArray($object);
		return $this;
	}
	
	public function GroupBy($object)
	{
		$this->groups = $this->ToArray($object);
		return $this;
	}
	
	public function ToList()
	{
	   $query = $this->CreateQuery();
	   $joins = $this->CreateJoinClause();
       $where = $this->CreateWhereClause();
	   $orders = $this->CreateOrderBy();
	   $groups = $this->CreateGroupBy();
	   $sql = $query.$joins.$where;
	   $sql .= $orders.$groups;
	   echo $sql;
	}
	
	private function CreateQuery()
	{
		$sv = implode(", ", $this->sv);
		$table = $this->table;
		$alias = $this->alias;
		if($alias)
		{
			$alias = "as $alias";
		}
		$query = "SELECT $sv FROM $table $alias";
		return $query;
	}
	
	private function CreateJoinClause()
	{
		$joinStr = "";
		foreach($this->joinArray as $join)
		{
			$joinStr .= " $join->type ";
			$joinStr .= " $join->table ";
			$joinStr .= " AS $join->alias ";
			$joinStr .= " ON $join->alias.$join->source ";
			$joinStr .= " = $this->alias.$join->target ";
		}
		
		return $joinStr;
	}
	
	private function CreateWhereClause()
	{
		$where = " WHERE 1=1 ";
		$count = 0;
		foreach($this->whereArray as $item)
		{
			$operator = " AND ";
			$operator = $this->operators[$count];
		    $where .= "$operator $item->key ";
			$v = is_string($item->value)?"'$item->value'":$item->value;
			$where .= "$item->operator $v";
		    $count++;
		}
		
		return $where;
		
	}
	
	private function CreateOrderBy()
	{
		if($this->orders)
		{
			return " ORDER BY $orders";
			$orders = implode(",", $this->orders);
		}
	}
	
	private function CreateGroupBy()
	{
		if($this->groups)
		{
			$groups = implode(",", $this->groups);
			return " GROUPS BY $groups";
		}
	}
	
	private function AddClause($obj)
	{
		$this->whereArray[] = $obj;
	}
	
	private function ToArray($object)
	{
		$search = $object;
		if(is_string($object))
		{
			$search = explode(",",$object);
		}
		if(!is_array($search))
			$search = (array) $object;
		return $search;
	}
}

$q = new Query();
$q = $q->From("etapa")->As("etp")->Select("id_etapa,grpe.id_grupoetapa, etp.nome");
$q = $q->InnerJoin("grupoetapa","id_grupoetapa","id_grupoetapa", "grpe");
$q = $q->Or()->eq("etp.id_grupoetapa",1);
$q = $q->Or()->eq("etp.nome","Desenvolvimento");
$q = $q->OrderBy(array("etp.nome"));
$list = $q->ToList();
?>